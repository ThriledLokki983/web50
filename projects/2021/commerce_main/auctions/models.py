from django.db import models
from django.contrib.auth.models import User
from datetime import datetime, date
from django.urls import reverse

# Create your models here.


class Listing(models.Model):
    title = models.CharField(max_length=65)
    bid_price = models.IntegerField()
    description = models.TextField()
    category = models.CharField(max_length=65)
    # An item must be placed on the market by a person
    person = models.ForeignKey(User, on_delete=models.CASCADE)
    # A user can like as many items and and item can have as many likes possible
    likes = models.ManyToManyField(User, related_name="liked_item")
    #bid = models.ManyToManyField(User, related_name="bid")

    def __str__(self):
        return '%s %s %s' % (self.person, self.title, self.category)

    def get_absolute_url(self):
        return reverse('auctions:item_info', args=(str(self.id)))
        # return reverse('auctions:index')


class Comment(models.Model):
    list_item = models.ForeignKey(
        Listing, on_delete=models.CASCADE, related_name="comments")
    name = models.CharField(max_length=255)
    body = models.TextField()
    date_added = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return '%s - %s' % (self.list_item.title, self.name)


class Category(models.Model):
    name = models.CharField(max_length=30)

    def __all__(self):
        return f"{self.name}"

    def get_absolute_url(self):
        return reverse('auctions:index')
