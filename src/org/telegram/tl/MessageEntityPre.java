/*
 *     This file is part of Telegram Server
 *     Copyright (C) 2015  Aykut Alparslan KOÇ
 *
 *     Telegram Server is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Telegram Server is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.telegram.tl;

import org.telegram.mtproto.ProtocolBuffer;

/**
 * Created by aykut on 19/11/15.
 */
public class MessageEntityPre extends TLMessageEntity {
    public static final int ID = 0x73924be0;

    public int offset;
    public int length;
    public String language;

    public MessageEntityPre() {
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        offset = buffer.readInt();
        length = buffer.readInt();
        language = buffer.readString();
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        serializeTo(buffer);
        return buffer;
    }

    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeInt(offset);
        buff.writeInt(length);
        buff.writeString(language);
    }

    public int getConstructor() {
        return ID;
    }
}
