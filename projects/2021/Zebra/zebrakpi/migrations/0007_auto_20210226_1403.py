# Generated by Django 3.0.1 on 2021-02-26 14:03

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('zebrakpi', '0006_auto_20210226_1337'),
    ]

    operations = [
        migrations.AlterField(
            model_name='kpidata',
            name='kpi_data_name',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='kpi_data_name', to='zebrakpi.UserSiteLanguageCountryMatrix'),
        ),
    ]