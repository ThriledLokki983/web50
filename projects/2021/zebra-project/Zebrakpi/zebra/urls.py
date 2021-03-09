
from django.urls import path
from django.contrib.auth import views as auth_views
from . import views 

from .views import InputKpi

urlpatterns = [
    path('', views.Index, name='index' ),
    path('total/', views.Total, name='total'),
    path('input/', InputKpi.as_view(), name='input_kpi')
]
