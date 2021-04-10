from rest_framework.generics import ListAPIView,CreateAPIView
from server.models import travel,fullUser,state
from django.contrib.auth.models import User
from rest_framework.response import Response 
from rest_framework.generics import RetrieveUpdateAPIView

from drf_registration.utils.common import import_string, import_string_list
from drf_registration.settings import drfr_settings
from drf_registration.utils.users import get_all_users
from .serializer import (
    travelListSerializer,
    travelCreateSerializer,
    fullUserListSerializer,
    fullUserCreateSerializer,
    fullUserUpdateSerializer,
    )

class userTravelListAPIView(ListAPIView):
    permission_classes = import_string_list(drfr_settings.PROFILE_PERMISSION_CLASSES)
    serializer_class =  travelListSerializer 
    queryset =travel.objects.all()
    def get_queryset(self):
        print( self.request.user.username)
        return travel.objects.filter(username= self.request.user.username)
    

class travelCreateAPIView(CreateAPIView):
    queryset = travel.objects.all()
    serializer_class = travelCreateSerializer 

class fullUserListAPIView(ListAPIView):
    permission_classes = import_string_list(drfr_settings.PROFILE_PERMISSION_CLASSES)
    serializer_class = fullUserListSerializer 
    queryset =fullUser.objects.all()

    def get_queryset(self):
        print( self.request.user.username)
        return fullUser.objects.filter(username= self.request.user.username)


class fullUserCreateAPIView(CreateAPIView):
    queryset = fullUser.objects.all()
    serializer_class = fullUserCreateSerializer

class fullUserUpdateAPIView(RetrieveUpdateAPIView):
    permission_classes = import_string_list(drfr_settings.PROFILE_PERMISSION_CLASSES)
    queryset = fullUser.objects.all()
    serializer_class = fullUserCreateSerializer
    lookup_field = 'username'


class sourceStateTravelListAPIView(ListAPIView):
    permission_classes = import_string_list(drfr_settings.PROFILE_PERMISSION_CLASSES)
    serializer_class = travelListSerializer 
    queryset =travel.objects.all()
    filterset_fields = [
            'ticket_category',
            'journey_date',
            'dest_state',
            'age',
            'purpose',]

    def get_queryset(self):
        return travel.objects.filter(source_state=self.request.user.first_name)

class destStateTravelListAPIView(ListAPIView):
    permission_classes = import_string_list(drfr_settings.PROFILE_PERMISSION_CLASSES)
    serializer_class = travelListSerializer 
    queryset =travel.objects.all()
    filterset_fields = [
            'ticket_category',
            'journey_date',
            'source_state',
            'age',
            'purpose',]

    def get_queryset(self):
        return travel.objects.filter(dest_state=self.request.user.first_name)
        

    
