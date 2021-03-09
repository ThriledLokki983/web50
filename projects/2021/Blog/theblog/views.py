from django.shortcuts import render, get_object_or_404
from django.views.generic import ListView, DetailView, CreateView, UpdateView, DeleteView
from django.urls import reverse_lazy, reverse
from django.http import HttpResponseRedirect

# Create your views here.
from .models import Post, Category, Comment
from .forms import PostForm, EditForm, CommentForm


'''def home(request):
    return render(request, "theblog/home.html", {})
'''


class Home(ListView):
    model = Post
    cats = Category.objects.all()
    template_name = 'theblog/home.html'
    ordering = ['-id']
    #ordering = ['-post_date']

    def get_context_data(self, *args, **kwargs):
        # we don't use filter because the only thing in there is "name"
        cat_menu = Category.objects.all()
        context = super(Home, self).get_context_data(*args, **kwargs)
        context["cat_menu"] = cat_menu
        return context


class ArticleDetail(DetailView):
    model = Post
    template_name = "theblog/article_detail.html"

    def get_context_data(self, *args, **kwargs):
        # we don't use filter because the only thing in there is "name"
        cat_menu = Category.objects.all()
        context = super(ArticleDetail, self).get_context_data(*args, **kwargs)
        stuff = get_object_or_404(Post, id=self.kwargs['pk'])
        total_likes = stuff.total_likes()
        liked = False
        if stuff.likes.filter(id=self.request.user.id).exists():
            liked = True
        context["cat_menu"] = cat_menu
        context['total_likes'] = total_likes
        context["liked"] = liked
        return context


class AddPost(CreateView):
    model = Post
    form_class = PostForm
    template_name = "theblog/add_post.html"
    #fields = "__all__"
    #fields = ('title', 'body')


class AddComment(CreateView):
    model = Comment
    form_class = CommentForm
    template_name = "theblog/add_comment.html"
    success_url = reverse_lazy('home')
    #fields = '__all__'

    def form_valid(self, form):
        form.instance.post_id = self.kwargs['pk']
        return super().form_valid(form)


def LikeView(request, pk):
    post = get_object_or_404(Post, id=request.POST.get('post_id'))
    liked = False
    if post.likes.filter(id=request.user.id).exists():
        post.likes.remove(request.user)
        liked = False
    else:
        post.likes.add(request.user)
        liked = True

    return HttpResponseRedirect(reverse('article_detail', args=[str(pk)]))


def CategoryView(request, cats):
    category_post = Post.objects.filter(category=cats.replace('-', ' '))
    return render(request, "theblog/category.html", {
        "cats": cats.replace('-', ' '),
        "category_post": category_post
    })


def CategoryList(request):
    cat_menu_list = Category.objects.all()
    return render(request, "theblog/category_list.html", {
        "cat_menu_list": cat_menu_list
    })


class AddCategory(CreateView):
    model = Category
    template_name = "theblog/add_category.html"
    fields = "__all__"


class UpdatePost(UpdateView):
    model = Post
    form_class = EditForm
    template_name = 'theblog/update_post.html'
    #fields = ('title', 'title_tag', 'body')


class DeletePost(DeleteView):
    model = Post
    template_name = 'theblog/delete_post.html'
    success_url = reverse_lazy('home')
