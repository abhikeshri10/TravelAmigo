# Generated by Django 3.1.2 on 2021-04-09 17:41

import datetime
from django.db import migrations, models
import phone_field.models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='fullUser',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('username', models.CharField(max_length=200, unique=True)),
                ('name', models.CharField(blank=True, max_length=20)),
                ('email', models.CharField(blank=True, max_length=20)),
                ('phone_number', phone_field.models.PhoneField(blank=True, max_length=31)),
                ('dob', models.DateField(default='1800-07-01', verbose_name='Date')),
                ('address_1', models.CharField(blank=True, max_length=20)),
                ('address_2', models.CharField(blank=True, max_length=20)),
                ('city', models.CharField(blank=True, max_length=20)),
                ('state', models.CharField(blank=True, max_length=20)),
                ('pincode', models.CharField(blank=True, max_length=6)),
                ('education', models.CharField(blank=True, max_length=20)),
                ('employment', models.CharField(blank=True, max_length=20)),
                ('married', models.BooleanField(default=False)),
            ],
        ),
        migrations.CreateModel(
            name='state',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('username', models.CharField(max_length=100)),
                ('state_name', models.CharField(max_length=20)),
            ],
        ),
        migrations.CreateModel(
            name='travel',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('username', models.CharField(max_length=200, unique=True)),
                ('ticket_category', models.CharField(max_length=20)),
                ('ticket_number', models.CharField(max_length=20)),
                ('journey_date', models.DateField(default=datetime.date.today, verbose_name='Date')),
                ('source_city', models.CharField(blank=True, max_length=20)),
                ('source_state', models.CharField(blank=True, max_length=20)),
                ('dest_city', models.CharField(blank=True, max_length=20)),
                ('dest_state', models.CharField(blank=True, max_length=20)),
                ('age', models.PositiveIntegerField()),
                ('duration_days', models.PositiveIntegerField()),
                ('purpose', models.CharField(max_length=100)),
            ],
        ),
    ]