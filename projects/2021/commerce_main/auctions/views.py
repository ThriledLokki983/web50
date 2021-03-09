from django.shortcuts import render, get_object_or_404
from django.views.generic import ListView, DetailView, UpdateView, CreateView
from django.urls import reverse_lazy, reverse
from django.http import HttpResponseRedirect

# Create your views here.
from .models import Listing, Comment
from .forms import CommentForm, ListForm


class Index(ListView):
    model = Listing
    template_name = 'auctions/index.html'


class ItemInfo(DetailView):
    model = Listing
    template_name = "auctions/iteminfo.html"


def Bid(request, bid_id):
    try:
        item = Listing.objects.get(pk=bid_id)
        if request.method == "POST":
            if request.POST['new_bid']:
                new_bid = request.POST['new_bid']
                item.bid_price = new_bid
                item.save()
    except item.DoesNotExist:
        return render(request, "auctions/index.html")
    return render(request, "auctions/bid.html", {
        "item": item
    })


class AddComment(CreateView):
    model = Comment
    form_class = CommentForm
    template_name = "auctions/add_comment.html"
    success_url = reverse_lazy('auctions:index')

    def form_valid(self, form):
        form.instance.list_item_id = self.kwargs['pk']
        return super().form_valid(form)


class AddList(CreateView):
    model = Listing
    form_class = ListForm
    template_name = "auctions/additem.html"

    def form_valid(self, form):
        form.instance.person_id = self.request.user.id
        return super().form_valid(form)
