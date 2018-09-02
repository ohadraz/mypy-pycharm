/*
 * Copyright 2018 Roberto Leinardi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.leinardi.pycharm.mypy.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.options.ShowSettingsUtil;
import com.intellij.openapi.project.Project;
import com.leinardi.pycharm.mypy.MypyConfigurable;
import com.leinardi.pycharm.mypy.MypyPlugin;

/**
 * Action to close the tool window.
 */
public class Settings extends BaseAction {

    @Override
    public void actionPerformed(final AnActionEvent event) {
        final Project project = PlatformDataKeys.PROJECT.getData(event.getDataContext());
        if (project == null) {
            return;
        }

        final MypyPlugin mypyPlugin = project.getComponent(MypyPlugin.class);
        if (mypyPlugin == null) {
            throw new IllegalStateException("Couldn't get mypy plugin");
        }

        ShowSettingsUtil.getInstance().editConfigurable(project, new MypyConfigurable(project));
    }

}