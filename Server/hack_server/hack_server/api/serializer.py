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
            'duration_days',
            'purpose',
        )

class fullUserListSerializer(ModelSerializer):
    class Meta:
        model = fullUser
        fields = (
            'city',
            'state',
            'phone_number',
            'username',
            'dob',
            'education',
            'employment',
            'married',
        )

class fullUserCreateSerializer(ModelSerializer):
    class Meta:
        model = fullUser
        fields = (
            'city',
            'state',
            'phone_number',
            'username',
            'dob',
            'education',
            'employment',
            'married',
        )
