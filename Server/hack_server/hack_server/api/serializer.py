from rest_framework.serializers import ModelSerializer
from server.models import fullUser,travel,state
from django.contrib.auth.models import User


class travelListSerializer(ModelSerializer):
    class Meta:
        model = travel
        fields = (
            'username',
            'ticket_category',
            'ticket_number',
            'journey_date',
            'source_city',
            'source_state',
            'dest_city',
            'dest_state',
            'age',
            'duration_days',
            'purpose',
            
        )

class travelCreateSerializer(ModelSerializer):
    class Meta:
        model = travel
        fields = (
            'username',
            'ticket_category',
            'ticket_number',
            'journey_date',
            'source_city',
            'source_state',
            'dest_city',
            'dest_state',
            'age',
            'duration_days',
            'purpose',
        )

class fullUserListSerializer(ModelSerializer):
    class Meta:
        model = fullUser
        fields = (
            'username',
            'name',
            'email',
            'phone_number'
            'dob',
            'address_1',
            'address_2',
            'city',
            'state',
            'pincode',
            'education',
            'employment',
            'married',
        )

class fullUserCreateSerializer(ModelSerializer):
    class Meta:
        model = fullUser
        fields = (
            'username',
            'name',
            'email',
            'phone_number'
            'dob',
            'address_1',
            'address_2',
            'city',
            'state',
            'pincode',
            'education',
            'employment',
            'married',
        )
