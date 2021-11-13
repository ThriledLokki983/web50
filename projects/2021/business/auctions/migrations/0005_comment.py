# Generated by Django 3.0.1 on 2021-02-24 13:17

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('auctions', '0004_auto_20210222_1532'),
    ]

    operations = [
        migrations.CreateModel(
            name='Comment',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('comment', models.CharField(max_length=555)),
                ('item_comment', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='item_comment', to='auctions.Listing')),
            ],
        ),
    ]