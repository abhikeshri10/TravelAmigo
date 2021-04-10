from django.urls import path
from .views import (
    userTravelListAPIView,
    travelCreateAPIView,
    fullUserListAPIView,
    fullUserCreateAPIView,
    fullUserUpdateAPIView,
    sourceStateTravelListAPIView,
    destStateTravelListAPIView,
    )

urlpatterns = [

    path('userTravelView',userTravelListAPIView.as_view(),name='list'),
    path('userTravelCreate',travelCreateAPIView.as_view(),name='create'),
    path('fullUserView',fullUserListAPIView.as_view(),name='userList'),
    path('fullUserCreate',fullUserCreateAPIView.as_view(),name='userCreate'),
    path('fullUserUpdate/<username>',fullUserUpdateAPIView.as_view(),name='userUpdate'),
    path('sourceStateView',sourceStateTravelListAPIView.as_view(),name='sourceState'),
    path('destStateView',destStateTravelListAPIView.as_view(),name='destState'),
    
]