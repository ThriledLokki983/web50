from django.contrib import admin

# Register your models here.

from . models import Site, Products, ProductSiteMatrix, ActivityGroup, Categories, GroupCatTypes, GroupCategoryMatrix, Language, Country, Role, SiteLanguageCountryMatrix, UserSiteLanguageCountryMatrix, WorkingDay, KpiData, KpiDefinition, KpiTarget, Status, KpiInput

admin.site.register(Site)
admin.site.register(Products)
admin.site.register(ActivityGroup)
admin.site.register(Categories)
admin.site.register(GroupCatTypes)
admin.site.register(Language)
admin.site.register(Country)
admin.site.register(Role)
admin.site.register(WorkingDay)
admin.site.register(Status)
admin.site.register(KpiData)
admin.site.register(KpiDefinition)
admin.site.register(KpiTarget)
admin.site.register(SiteLanguageCountryMatrix)
admin.site.register(UserSiteLanguageCountryMatrix)
admin.site.register(GroupCategoryMatrix)
admin.site.register(ProductSiteMatrix)
admin.site.register(KpiInput)


