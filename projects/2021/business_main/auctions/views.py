from django.shortcuts import render
from django.views.generic import ListView, DetailView, CreateView

# Create your views here.
from .models import Listing
from .forms import AddListForm


class Index(ListView):
    model = Listing
    template_name = 'auctions/index.html'
    ordering = ['-id']


class ItemDetail(DetailView):
    model = Listing
    template_name = 'auctions/itemdetail.html'


class AddList(CreateView):
    model = Listing
    form_class = AddListForm
    template_name = "auctions/addlist.html"
