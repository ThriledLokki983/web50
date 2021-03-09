from django.db import models
from django.contrib.auth.models import User
from datetime import date, datetime

# Create your models here.


class Site(models.Model):
    author = models.ForeignKey(User, on_delete=models.CASCADE)
    company_name = models.CharField(max_length=65)
    site_name = models.CharField(max_length=65)
    country = models.CharField(max_length=50)
    sbu = models.CharField(max_length=50)
    eam_no = models.CharField(max_length=12)
    shop = models.BooleanField()

    def __str__(self):
        return f"{self.company_name} {self.country} {self.shop}"


class Products(models.Model):
    product_code = models.CharField(max_length=3)
    product_type = models.CharField(max_length=50)
    description = models.CharField(max_length=50)

    def __str__(self):
        return f"{self.product_type} {self.product_code}"


class ProductSiteMatrix(models.Model):
    site = models.ForeignKey(
        Site, on_delete=models.CASCADE, related_name="site")
    product = models.ForeignKey(
        Products, on_delete=models.CASCADE, related_name="product")

    def __str__(self):
        return f"{self.site} {self.product}"


class ActivityGroup(models.Model):
    activity_name = models.CharField(max_length=40)
    is_sep_by_prod_type = models.BooleanField()

    def __str__(self):
        return f"{self.activity_name}"


class Categories(models.Model):
    cat_name = models.CharField(max_length=40)

    def __str__(self):
        return f"{self.cat_name}"


class GroupCatTypes(models.Model):
    groucattypes_name = models.CharField(max_length=40)

    def __str__(self):
        return f"{self.groucattypes_name}"


class GroupCategoryMatrix(models.Model):
    activity_group = models.ForeignKey(
        ActivityGroup, on_delete=models.CASCADE, related_name="activity_group")
    category_name = models.ForeignKey(
        Categories, on_delete=models.CASCADE, related_name="category_name")
    group_category_name = models.ForeignKey(
        GroupCatTypes, on_delete=models.CASCADE, related_name="group_category_name")

    def __str__(self):
        return f"{self.activity_group.activity_name} {self.category_name.cat_name} {self.group_category_name.groucattypes_name}"


class Language(models.Model):
    lang_name = models.CharField(max_length=50)
    lang_code = models.CharField(max_length=5)

    def __str__(self):
        return "%s %s" % (self.lang_code, self.lang_name)


class Country(models.Model):
    country_name = models.CharField(max_length=50)
    country_code = models.CharField(max_length=10)

    def __str__(self):
        return "%s %s" % (self.country_code, self.country_name)


class Role(models.Model):
    role_name = models.CharField(max_length=50)

    def __str__(self):
        return "%s" % (self.role_name)


class SiteLanguageCountryMatrix(models.Model):
    site_lang_matrix_name = models.ForeignKey(
        Language, on_delete=models.CASCADE, related_name="site_lang_matrix_name")
    site_master = models.ForeignKey(
        Site, on_delete=models.CASCADE, related_name="site_master")
    country_master = models.ForeignKey(
        Country, on_delete=models.CASCADE, related_name="country_master")
    active = models.BooleanField()

    def __str__(self):
        return "%s %s %s" % (self.site_master, self.site_lang_matrix_name, self.country_master)


class UserSiteLanguageCountryMatrix(models.Model):
    site_lang_coun_matrix = models.ForeignKey(
        SiteLanguageCountryMatrix, on_delete=models.CASCADE, related_name="site_lang_count_matrix")
    user_relation = models.ForeignKey(
        User, on_delete=models.CASCADE, related_name="user_relation")
    role_relation = models.ForeignKey(
        Role, on_delete=models.CASCADE, related_name="role_relation")

    def __str__(self):
        return "%s %s %s" % (self.role_relation.role_name, self.user_relation.username, self.site_lang_coun_matrix.site_lang_matrix_name.lang_name)


class WorkingDay(models.Model):
    site_work_day = models.ForeignKey(
        Site, on_delete=models.CASCADE, related_name="site_workday")
    day = models.CharField(max_length=50)
    is_working_day = models.BooleanField()

    def __str__(self):
        return f"{self.day}"


class KpiDefinition(models.Model):
    kpi_group_def = models.ForeignKey(
        GroupCategoryMatrix, on_delete=models.CASCADE, related_name="kpi_group_de")
    formulae = models.CharField(max_length=5)

    def __str__(self):
        return "%s" % (self.kpi_group_def.group_category_name)


class KpiTarget(models.Model):
    kpi_def = models.ForeignKey(
        KpiDefinition, on_delete=models.CASCADE, related_name="kpi_def")
    site_language_count = models.ForeignKey(
        SiteLanguageCountryMatrix, on_delete=models.CASCADE, related_name="site_language_count")
    active = models.BooleanField()

    def __str__(self):
        return "%s" % (self.kpi_def.kpi_group_def.activity_group.activity_name)


class Status(models.Model):
    name = models.CharField(max_length=50)
    active = models.BooleanField()

    def __str__(self):
        return "%s" % (self.name)


class KpiData(models.Model):
    kpi_data_name = models.ForeignKey(
        UserSiteLanguageCountryMatrix, on_delete=models.CASCADE, related_name="kpi_data_name")
    status_data_name = models.ForeignKey(
        Status, on_delete=models.CASCADE, related_name="status_data_name")
    year = models.DateField(auto_now_add=True)

    def __str__(self):
        return "%s" % (self.kpi_data_name.site_lang_coun_matrix.site_lang_matrix_name.lang_name)
