package com.yooyo.poi.di.component;


import com.yooyo.poi.Application;
import com.yooyo.poi.di.module.ApiModule;
import com.yooyo.poi.di.module.AppModule;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        ApiModule.class
})
public interface AppComponent {
    Application inject(Application application);
}
