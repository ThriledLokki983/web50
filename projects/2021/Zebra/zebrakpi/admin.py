from django.contrib import admin

# Register your models here.
from .models import Site, Products, ProductSiteMatrix, ActivityGroup, Categories, GroupCategoryMatrix, GroupCatTypes, Role, Country, Language, SiteLanguageCountryMatrix, UserSiteLanguageCountryMatrix, KpiData, KpiTarget, Status, KpiDefinition, WorkingDay
# Register your models here.

admin.site.register(Site)
admin.site.register(Products)
admin.site.register(ProductSiteMatrix)
admin.site.register(ActivityGroup)
admin.site.register(Categories)
admin.site.register(GroupCategoryMatrix)
admin.site.register(GroupCatTypes)
admin.site.register(Role)
admin.site.register(Country)
admin.site.register(Language)
admin.site.register(SiteLanguageCountryMatrix)
admin.site.register(UserSiteLanguageCountryMatrix)
admin.site.register(KpiData)
admin.site.register(KpiTarget)
admin.site.register(Status)
admin.site.register(KpiDefinition)
admin.site.register(WorkingDay)
