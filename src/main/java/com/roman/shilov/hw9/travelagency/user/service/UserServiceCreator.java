package com.roman.shilov.hw9.travelagency.user.service;

import com.roman.shilov.hw9.travelagency.common.buisness.application.StorageType;
import com.roman.shilov.hw9.travelagency.user.repo.impl.UserMemoryArrayRepo;
import com.roman.shilov.hw9.travelagency.user.repo.impl.UserMemoryCollectionRepo;
import com.roman.shilov.hw9.travelagency.user.service.impl.UserDefaultService;

public final class UserServiceCreator {
    private UserServiceCreator() {
    }

    public static UserService getCityService(StorageType storageType){
        switch (storageType){

            case MEMORY_ARRAY:
                return new UserDefaultService(new UserMemoryArrayRepo());

            case MEMORY_COLLECTION:
                return new UserDefaultService(new UserMemoryCollectionRepo());

            default: return null;
        }
    }
}
