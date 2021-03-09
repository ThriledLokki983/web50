from django import forms
from django.forms import ModelForm


#Import my model class into this forms
from .models import KpiInput


class KpiInputForm(forms.ModelForm):
        class Meta:
                model = KpiInput
                fields = ('day', 'sitelanguagecountry_matrix')

                widgets = {
                        'day': forms.Select(attrs={'class': 'form-control'}),
                        'sitelanguagecountry_matrix': forms.Select(attrs={'class': 'form-control'}),
                        #'year': forms.NumberInput(attrs={'class': 'form-control'}),
                }