/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 *
 */

package sun.jvm.hotspot.asm.sparc;

import sun.jvm.hotspot.asm.*;

public class SPARCV9WrprInstruction extends SPARCV9PrivilegedRegisterInstruction {
    final private SPARCRegister rs1;
    final private ImmediateOrRegister operand2;

    public SPARCV9WrprInstruction(SPARCRegister rs1, ImmediateOrRegister operand2,
                                  int regNum) {
        super("wrpr", regNum);
        this.rs1 = rs1;
        this.operand2 = operand2;
    }

    protected String getDescription() {
        StringBuffer buf = new StringBuffer();
        buf.append(getName());
        buf.append(spaces);
        buf.append(rs1.toString());
        buf.append(comma);
        if (operand2.isRegister()) {
            buf.append(operand2.toString());
        } else {
            int value = ((Immediate)operand2).getNumber().intValue();
            buf.append(Integer.toHexString(value));
        }
        buf.append(comma);
        buf.append(getPrivilegedRegisterName(regNum));
        return buf.toString();
    }

    public SPARCRegister getSourceRegister1() {
        return rs1;
    }

    public ImmediateOrRegister getOperand2() {
        return operand2;
    }
}
