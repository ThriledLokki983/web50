# Generated by Django 3.1.7 on 2021-03-04 19:54

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('zebra', '0002_auto_20210303_1344'),
    ]

    operations = [
        migrations.AddField(
            model_name='kpidefinition',
            name='week',
            field=models.CharField(default=None, max_length=25),
        ),
        migrations.AddField(
            model_name='kpidefinition',
            name='year',
            field=models.IntegerField(default=None),
        ),
    ]
