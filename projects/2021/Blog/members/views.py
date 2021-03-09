from django.shortcuts import render, get_object_or_404
from django.views import generic
from django.views.generic import DetailView, UpdateView, CreateView
from django.contrib.auth.forms import UserCreationForm, UserChangeForm, PasswordChangeForm
from django.contrib.auth.views import PasswordChangeView
from django.urls import reverse_lazy
from .forms import SignUpForm, EditProfileForm, PasswordChangingForm, ProfilePageForm

from theblog.models import Profile


# Create your views here.
class EditProfilePage(generic.UpdateView):
    model = Profile
    template_name = 'registration/edit_profilepage.html'
    fields = ['bio', 'profile_pic', 'website_url',
              'facebook_url', 'instagram_url', 'github_url']
    success_url = reverse_lazy('home')


class CreateProfilePage(CreateView):
    model = Profile
    form_class = ProfilePageForm
    template_name = 'registration/create_userprofilepage.html'
    #fields = '__all__'

    # Figure out which user is filling the form
    # The form will submit a user (id) and the code below will hijack this form
    # as it is being process and pause that processing, insert back the user and continue processing
    def form_valid(self, form):
        form.instance.user = self.request.user
        return super().form_valid(form)


class ShowProfile(DetailView):
    model = Profile
    template_name = 'registration/user_profile.html'

    def get_context_data(self, *args, **kwargs):
        #users = Profile.objects.all()
        context = super(ShowProfile, self).get_context_data(*args, **kwargs)

        # we will get the pk which is going to be passed through the url
        page_user = get_object_or_404(Profile, id=self.kwargs['pk'])

        # Pass the information into the page through the context variable
        context['page_user'] = page_user
        return context


def password_success(request):
    return render(request, "registration/password_success.html", {

    })


class PasswordChange(PasswordChangeView):
    form_class = PasswordChangingForm
    success_url = reverse_lazy('password_success')


class UserRegister(generic.CreateView):
    form_class = SignUpForm
    template_name = 'registration/register.html'
    success_url = reverse_lazy('login')


class UserEdit(generic.UpdateView):
    form_class = EditProfileForm
    template_name = 'registration/edit_profile.html'
    success_url = reverse_lazy('home')

    def get_object(self):
        return self.request.user
