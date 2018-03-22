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

package io.kamax.vbox5_2.setting.snapshot;

import io.kamax.hbox.constant.SnapshotAttribute;
import io.kamax.hbox.exception.ConfigurationException;
import io.kamax.tools.setting.PositiveNumberSetting;
import io.kamax.tools.setting._Setting;
import io.kamax.vbox5_2.setting._SnapshotSettingAction;
import org.virtualbox_5_2.ISnapshot;
import org.virtualbox_5_2.LockType;

public class SnapshotCreationTimeSettingAction implements _SnapshotSettingAction {

    @Override
    public LockType getLockType() {
        return LockType.Shared;
    }

    @Override
    public String getSettingName() {
        return SnapshotAttribute.CreationTime.getId();
    }

    @Override
    public void set(ISnapshot snap, _Setting setting) {
        throw new ConfigurationException("Read-only attribute: " + setting.getName());
    }

    @Override
    public _Setting get(ISnapshot snap) {
        return new PositiveNumberSetting(SnapshotAttribute.CreationTime, snap.getTimeStamp());
    }

}