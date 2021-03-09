from django.contrib import admin

# Register your models here.
from .models import Listing, User, Comment

admin.site.register(Listing)
admin.site.register(Comment)