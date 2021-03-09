from django.shortcuts import render
from itertools import chain
from operator import attrgetter
from django.views.generic import CreateView





from .models import Site, Products, ProductSiteMatrix, ActivityGroup, Categories, GroupCatTypes, GroupCategoryMatrix, Language, Country, Role, SiteLanguageCountryMatrix, UserSiteLanguageCountryMatrix, WorkingDay, KpiData, KpiDefinition, KpiTarget, Status, KpiInput
from .forms import KpiInputForm 
# Create your views here.

def Index(request):
        # Bring up possible site language country and week combination
        site = Site.objects.all()
        language = Language.objects.all()
        country = Country.objects.all()
        weeks = KpiData.objects.filter(week=1)
        return render(request, 'zebra/index.html', {
                'site': site,
                'language': language,
                'country': country,
                'weeks': weeks,
        })
        # View Totals for all calls + Lost calls + Outbound calls



def Total(request):
        all_calls = Categories.objects.all().filter(cat_name__icontains='calls')[0:4]
        ans_calls = Categories.objects.all().filter(cat_name__icontains='answer')
        ac1 = GroupCategoryMatrix.objects.all()
        out_calls = ac1.filter()
        return render(request, 'zebra/total.html', {
                'all_calls': all_calls,
                'ans_calls': ans_calls,
        })

class InputKpi(CreateView):
        model = KpiInput 
        form_class = KpiInputForm
        template_name = 'zebra/inputkpi.html'
        
   
