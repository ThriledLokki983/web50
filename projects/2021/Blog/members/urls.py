from django.urls import path
from .views import UserRegister, UserEdit, PasswordChange, ShowProfile, EditProfilePage, CreateProfilePage
# Need this for editing password
from django.contrib.auth import views as auth_views
from . import views

urlpatterns = [
    path("register/", UserRegister.as_view(), name="register"),
    path("edit_profile/", UserEdit.as_view(), name="edit_profile"),
    # path("password/", auth_views.PasswordChangeView.as_view(template_name = 'registration/change-password.html')),
    path("password/", PasswordChange.as_view(
        template_name='registration/change-password.html')),
    path("password_success/", views.password_success, name='password_success'),
    path("<int:pk>/profile", ShowProfile.as_view(), name='show_profile'),
    path("<int:pk>/edit_profilepage",
         EditProfilePage.as_view(), name='edit_profilepage'),
    path("create_profilepage/", CreateProfilePage.as_view(),
         name='create_profilepage'),
]
