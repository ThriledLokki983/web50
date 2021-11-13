# Generated by Django 3.1.7 on 2021-03-05 15:57

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('zebra', '0005_auto_20210305_1646'),
    ]

    operations = [
        migrations.CreateModel(
            name='KpiInput',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('day', models.CharField(default='provide day', max_length=10)),
                ('year', models.DateField()),
                ('sitelanguagecountry_matrix', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='sitelanguecountry_matrix', to='zebra.sitelanguagecountrymatrix')),
                ('status', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='status', to='zebra.status')),
            ],
        ),
    ]