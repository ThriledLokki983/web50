# Generated by Django 3.0.1 on 2021-02-24 20:58

import datetime
from django.db import migrations, models
from django.utils.timezone import utc


class Migration(migrations.Migration):

    dependencies = [
        ('auctions', '0009_auto_20210224_2054'),
    ]

    operations = [
        migrations.AddField(
            model_name='comment',
            name='date_added',
            field=models.DateTimeField(auto_now_add=True, default=datetime.datetime(2021, 2, 24, 20, 58, 47, 840692, tzinfo=utc)),
            preserve_default=False,
        ),
    ]