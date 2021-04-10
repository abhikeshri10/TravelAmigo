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
    
    def get_queryset(self):
        queryset =travel.objects.filter(source_state=self.request.user.first_name)
        highAge = self.request.query_params.get('highAge')
        lowAge = self.request.query_params.get('lowAge')
        startDate = self.request.query_params.get('startDate')
        endDate = self.request.query_params.get('endDate')
        purpose = self.request.query_params.get('purposee')
        destState = self.request.query_params.get('destState')
        
        if highAge is not None:
            queryset = queryset.filter(age__lte=highAge)
        if lowAge is not None:
            queryset = queryset.filter(age__gte=lowAge)
        if endDate is not None:
            queryset = queryset.filter(journey_date__lte=endDate)
        if startDate is not None:
            queryset = queryset.filter(journey_date__gte=startDate)
        if purpose is not None:
            queryset = queryset.filter(purpose=purpose)
        if destState is not None:
            queryset = queryset.filter(dest_state=destState)
                
        return queryset
        

class destStateTravelListAPIView(ListAPIView):
    #permission_classes = import_string_list(drfr_settings.PROFILE_PERMISSION_CLASSES)
    serializer_class = travelListSerializer 
    
    def get_queryset(self):
        queryset = travel.objects.all()
        #queryset =travel.objects.filter(dest_state=self.request.user.first_name)
        highAge = self.request.query_params.get('highAge')
        lowAge = self.request.query_params.get('lowAge')
        startDate = self.request.query_params.get('startDate')
        endDate = self.request.query_params.get('endDate')
        purpose = self.request.query_params.get('purposee')
        sourceState = self.request.query_params.get('sourceState')
        
        if highAge is not None:
            queryset = queryset.filter(age__lte=highAge)
        if lowAge is not None:
            queryset = queryset.filter(age__gte=lowAge)
        if endDate is not None:
            queryset = queryset.filter(journey_date__lte=endDate)
        if startDate is not None:
            queryset = queryset.filter(journey_date__gte=startDate)
        if purpose is not None:
            queryset = queryset.filter(purpose=purpose)
        if sourceState is not None:
            queryset = queryset.filter(source_state=sourceState)
                
        return queryset
        

    
