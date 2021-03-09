from django.urls import path

from . import views

urlpatterns = [
    path("", views.index, name="index"),
    path("login", views.login_view, name="login"),
    path("logout", views.logout_view, name="logout"),
    path("register", views.register, name="register"),
    path("add", views.add, name="add"),
    path("view/<int:list_id>", views.view, name="view"),
    path("bid/<int:bid_id>", views.bid, name="bid"),
    path("comment/<int:item_id>", views.comment, name="comment")

]
