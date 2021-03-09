from django.urls import path

from .views import Index, ItemInfo, Bid, AddComment, AddList
from . import views

app_name = "auctions"

urlpatterns = [

    path("", Index.as_view(), name="index"),
    path("listing/<int:pk>", ItemInfo.as_view(), name="item_info"),
    path("bid/<int:bid_id>", Bid, name="bid"),
    path("item/<int:pk>/comment", AddComment.as_view(), name="add_comment"),
    path("add-a-list/", AddList.as_view(), name="add_item"),

]
