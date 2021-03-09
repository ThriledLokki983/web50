from django import forms
from .models import Listing


class AddListForm(forms.ModelForm):
    class Meta:
        model = Listing
        fields = ('title', 'author', 'startbidprice',
                  'quantity', 'category', 'description')

        widgets = {
            'title': forms.TextInput(attrs={'class': 'form-control'}),
            'author': forms.Select(attrs={'class': 'form-control'}),
            'category': forms.Select(attrs={'class': 'form-control'}),
            'startbidprice': forms.TextInput(attrs={'class': 'form-control'}),
            'quantity': forms.TextInput(attrs={'class': 'form-control'}),
            'description': forms.Textarea(attrs={'class': 'form-control'}),
        }
