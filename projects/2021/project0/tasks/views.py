from django.shortcuts import render
from django import forms
from django.http import HttpResponseRedirect
from django.urls import reverse

tasks = []
# Create your views here.


class NewTaskForm(forms.Form):
    task = forms.CharField(label="New Task")
    # priority = forms.IntegerField(label="Priority", min_value=1, max_value=10)


def index(request):
    if "tasks" not in request.session:
        request.session["tasks"] = []
    return render(request, "tasks/index.html",
                  {
                      "tasks": request.session["tasks"]
                  })


def add(request):
    if request.method == 'POST':
        NewTask = NewTaskForm(request.POST)
        if NewTask.is_valid():
            task = NewTask.cleaned_data["task"]
            request.session["tasks"] += [task]
            return HttpResponseRedirect(reverse("tasks:index"))
        else:
            return render(request, "tasks/add.html", {
                "form": NewTask
            })

    return render(request, "tasks/add.html", {
        "form": NewTaskForm()
    })
