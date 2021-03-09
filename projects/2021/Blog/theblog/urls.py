from django.urls import path

from . import views
from .views import Home, ArticleDetail, AddPost, UpdatePost, DeletePost, CategoryView, AddCategory, CategoryList, LikeView, AddComment

urlpatterns = [
    #path("", views.home, name="home")
    path("", Home.as_view(), name="home"),
    path("article/<int:pk>", ArticleDetail.as_view(), name="article_detail"),
    path("add_post/", AddPost.as_view(), name="add_post"),
    path("add_category/", AddCategory.as_view(), name="add_category"),
    path("article/edit/<int:pk>", UpdatePost.as_view(), name="update_post"),
    path("article/<int:pk>/delete", DeletePost.as_view(), name="delete_post"),
    path("category/<str:cats>", CategoryView, name="category"),
    path("category_list/", views.CategoryList, name="category_list"),
    path("like/<int:pk>", LikeView, name="like_post"),
    path("article/<int:pk>/comment", AddComment.as_view(), name="add_comment"),

]
