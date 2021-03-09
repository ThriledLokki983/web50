from django.db import models
from django.contrib.auth.models import User
from django.urls import reverse
# Create your models here.


CATEGORIES = [
    ("FASHION", "Fashion"), ("ELECT",
                             "Electronics"), ("TOYS", "Toys"), ("ANT", "Antique"), ("HOME", "Home"), ("OTHERS", "Others")]


class Listing(models.Model):
    title = models.CharField(max_length=65)
    category = models.CharField(choices=CATEGORIES, max_length=10, default=7)
    startbidprice = models.DecimalField(decimal_places=2, max_digits=1000)
    author = models.ForeignKey(User, on_delete=models.CASCADE)
    quantity = models.IntegerField(default=1)
    description = models.TextField()

    def __str__(self):
        return f"{self.title}: {self.startbidprice} {self.description} {self.category}"

    def get_absolute_url(self):
        # return reverse('item_detail', args=(str(self.id)))
        return reverse('home')
