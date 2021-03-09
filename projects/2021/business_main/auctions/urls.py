
from django.urls import path
from .views import Index, ItemDetail, AddList

urlpatterns = [
    path("", Index.as_view(), name="index"),
    path("itemdetail/<int:pk>", ItemDetail.as_view(), name="item_detail"),
    path("add_list/", AddList.as_view(), name="add_list"),
]
