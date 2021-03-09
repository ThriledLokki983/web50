from django.contrib.auth import authenticate, login, logout
from django.db import IntegrityError
from django.http import HttpResponse, HttpResponseRedirect
from django.shortcuts import render
from django.urls import reverse
from django.core.exceptions import ObjectDoesNotExist

from .models import User, Listing, CATEGORIES, Comment


def index(request):
    if not request.user.is_authenticated:
        return HttpResponseRedirect(reverse("login"))
    # current_user = request.session.get("user")
    listing = Listing.objects.all()
    comment = Comment.objects.all()
    return render(request, "auctions/index.html", {
        "listing": listing,
        "comment": comment
    })


def login_view(request):
    if request.method == "POST":
        # Attempt to sign user in
        username = request.POST["username"]
        password = request.POST["password"]
        user = authenticate(request, username=username, password=password)

        # Check if authentication successful
        if user is not None:
            login(request, user)
            return HttpResponseRedirect(reverse("index"))
        else:
            return render(request, "auctions/login.html", {
                "message": "Invalid username and/or password."
            })
    else:
        return render(request, "auctions/login.html")


def logout_view(request):
    logout(request)
    return HttpResponseRedirect(reverse("index"))


def register(request):
    if request.method == "POST":
        username = request.POST["username"]
        email = request.POST["email"]

        # Ensure password matches confirmation
        password = request.POST["password"]
        confirmation = request.POST["confirmation"]
        if password != confirmation:
            return render(request, "auctions/register.html", {
                "message": "Passwords must match."
            })

        # Attempt to create new user
        try:
            user = User.objects.create_user(username, email, password)
            user.save()
        except IntegrityError:
            return render(request, "auctions/register.html", {
                "message": "Username already taken."
            })
        login(request, user)
        return HttpResponseRedirect(reverse("index"))
    else:
        return render(request, "auctions/register.html")


def add(request):
    category = CATEGORIES[0:20]
    if request.method == "POST":
        if request.POST['title'] and request.POST['startbidprice'] and request.POST['quantity'] and request.POST['description'] and request.POST['category']:
            title = request.POST['title']
            startbid = request.POST['startbidprice']
            qty = request.POST['quantity']
            desc = request.POST['description']
            cat = request.POST.get('category')
            listing = Listing(
                title=title, startbidprice=startbid, quantity=qty, description=desc, category=cat)  # [:-2][10:]
            listing.save()
            # return HttpResponse(new_listing)
            new_listing = Listing.objects.all()
            return render(request, "auctions/index.html", {
                "listing": new_listing
            })
        else:
            return render(request, "auctions/add.html", {
                "category": category
            })
    else:
        return render(request, "auctions/add.html", {
            "category": category
        })


def view(request, list_id):
    try:
        item = Listing.objects.get(pk=list_id)
    except item.DoesNotExist:
        return render(request, "auctions/index.html")
    else:
        return render(request, "auctions/view.html", {
            "item": item
        })


def bid(request, bid_id):
    try:
        item = Listing.objects.get(pk=bid_id)
        if request.method == "POST":
            if request.POST['new_bid']:
                new_bid = request.POST['new_bid']
                item.startbidprice = new_bid
                item.save()
    except item.DoesNotExist:
        return render(request, "auctions/index.html")
    return render(request, "auctions/bid.html", {
        "item": item
    })


def comment(request, item_id):
    try:
        item = Listing.objects.get(pk=item_id)
        if request.method == "POST":
            if request.POST['comment']:
                comment = Comment.objects.get(pk=item.id)
                comments = request.POST['comment']
                comment.comment += comments
                comment.save()
    except Listing.DoesNotExist:
        item.comment.add(comment)
        return render(request, "auctions/index", {
            "comment": comment,
            "item": item
        })
    return render(request, "auctions/comment.html", {
        "item": item
    })
