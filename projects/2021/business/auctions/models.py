from django.contrib.auth.models import AbstractUser
from django.db import models

"""CATEGORIES = ["Fashion", "Electronics", "Toys", "Antique", "Home"]"""

CATEGORIES = [
    ("FASHION", "Fashion"), ("ELECT",
                             "Electronics"), ("TOYS", "Toys"), ("ANT", "Antique"), ("HOME", "Home"), ("OTHERS", "Others")]


class User(AbstractUser):  # Have a default user table setup for me
    is_student = models.BooleanField(default=False)

    def __str__(self):
        f"{self.username}"


class Listing(models.Model):
    title = models.CharField(max_length=50)  # max_length required
    startbidprice = models.DecimalField(decimal_places=2, max_digits=1000)
    description = models.TextField(blank=True, null=True)
    category = models.CharField(choices=CATEGORIES, max_length=10, default=7)
    quantity = models.IntegerField(default=1)

    def __str__(self):
        return f"{self.title}: {self.startbidprice} {self.description} {self.category} {self.quantity}"


class Comment(models.Model):
    listing = models.ForeignKey(
        Listing, on_delete=models.CASCADE, default=1, related_name="comments")
    comment = models.TextField()
    name = models.CharField(max_length=255, default="user_name")
    date_added = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return f"{self.listing.title} {self.name} {self.comment}"
