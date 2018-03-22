/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2018 Kamax Sarl
 * 
 * http://kamax.io/hbox/
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.vbox5_2.setting.storage;

import io.kamax.hbox.constant.StorageControllerAttribute;
import io.kamax.hbox.exception.HyperboxException;
import io.kamax.tools.setting._Setting;
import io.kamax.vbox.settings.storage.ControllerNameSetting;
import io.kamax.vbox5_2.setting._StorageControllerSettingAction;
import org.virtualbox_5_2.IStorageController;
import org.virtualbox_5_2.LockType;

public final class ControllerNameSettingAction implements _StorageControllerSettingAction {

    @Override
    public LockType getLockType() {
        return LockType.Write;
    }

    @Override
    public String getSettingName() {
        return StorageControllerAttribute.Name.toString();
    }

    @Override
    public void set(IStorageController sct, _Setting setting) {
        if (!setting.getString().contentEquals(get(sct).getString())) {
            throw new HyperboxException("Read-only setting");
        }
    }

    @Override
    public _Setting get(IStorageController sct) {
        return new ControllerNameSetting(sct.getName());
    }

}