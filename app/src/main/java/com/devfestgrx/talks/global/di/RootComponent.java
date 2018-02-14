/*
 * Copyright (C) 2016 Olmo Gallegos Hernández.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.devfestgrx.talks.global.di;

import com.devfestgrx.talks.global.App;
import com.devfestgrx.talks.ui.activity.TalkDetailActivity;
import com.devfestgrx.talks.ui.activity.TalksActivity;

import dagger.Component;

@Component(modules = MainModule.class)
public interface RootComponent {
    void inject(App app);

    void inject(TalksActivity activity);

    void inject(TalkDetailActivity activity);
}
