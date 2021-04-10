from django.db import models
from django.contrib.auth.models import User
from phone_field import PhoneField
from datetime import datetime,date

# Create your models here.

class fullUser(models.Model):

    username = models.CharField(max_length=200,unique=True)
    name = models.CharField(max_length=20,blank=True)
    email = models.CharField(max_length=20,blank=True)
    phone_number = PhoneField(blank=True)
    dob = models.DateField(("Date"),default='1800-07-01')
    address_1 = models.CharField(max_length=20,blank=True)
    address_2 = models.CharField(max_length=20,blank=True)
    city = models.CharField(max_length=20,blank=True)
    state = models.CharField(max_length=20,blank=True)
    pincode = models.CharField(max_length=6,blank=True)
    education = models.CharField(max_length=20,blank=True)
    employment = models.CharField(max_length=20,blank=True)
    married = models.BooleanField(default=False)
    

class travel(models.Model):
    username = models.CharField(max_length=200,blank=True)
    ticket_category = models.CharField(max_length=20,blank=True)
    ticket_number = models.CharField(max_length=20,blank=True)
    journey_date = models.DateField(("Date"),default=date.today)
    source_city = models.CharField(max_length=20,blank=True)
    source_state = models.CharField(max_length=20,blank=True)
    dest_city = models.CharField(max_length=20,blank=True)
    dest_state = models.CharField(max_length=20,blank=True)
    age = models.PositiveIntegerField()
    duration_days = models.PositiveIntegerField()
    purpose = models.CharField(max_length=100)


class state(models.Model):
    username = models.CharField(max_length=100)
    state_name = models.CharField(max_length=20)