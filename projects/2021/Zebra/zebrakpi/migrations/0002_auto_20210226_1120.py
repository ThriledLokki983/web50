# Generated by Django 3.0.1 on 2021-02-26 11:20

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('zebrakpi', '0001_initial'),
    ]

    operations = [
        migrations.RenameField(
            model_name='sites',
            old_name='user',
            new_name='author',
        ),
    ]