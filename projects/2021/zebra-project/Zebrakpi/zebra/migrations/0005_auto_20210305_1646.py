# Generated by Django 3.1.7 on 2021-03-05 15:46

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('zebra', '0004_auto_20210305_1644'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='kpidefinition',
            name='week',
        ),
        migrations.RemoveField(
            model_name='kpidefinition',
            name='year',
        ),
        migrations.AddField(
            model_name='kpidata',
            name='week',
            field=models.CharField(default=None, max_length=25),
        ),
    ]
