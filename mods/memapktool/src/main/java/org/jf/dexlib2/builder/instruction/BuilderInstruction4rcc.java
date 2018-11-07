/*
 * Copyright 2012, Google Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.jf.dexlib2.builder.instruction;

import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction4rcc;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.util.Preconditions;


public class BuilderInstruction4rcc extends BuilderInstruction implements Instruction4rcc {
    public static final Format FORMAT = Format.Format4rcc;

    protected final int startRegister;
    protected final int registerCount;

    protected final Reference reference;
    protected final Reference reference2;

    public BuilderInstruction4rcc(Opcode opcode,
                                  int startRegister,
                                  int registerCount,
                                  Reference reference,
                                  Reference reference2) {
        super(opcode);
        this.startRegister = Preconditions.checkShortRegister(startRegister);
        this.registerCount = Preconditions.checkRegisterRangeCount(registerCount);
        this.reference = reference;
        this.reference2 = reference2;
    }

    @Override
    public int getStartRegister() {
        return startRegister;
    }

    @Override
    public int getRegisterCount() {
        return registerCount;
    }

    @Override
    public Reference getReference() {
        return reference;
    }

    @Override
    public int getReferenceType() {
        return opcode.referenceType;
    }

    @Override
    public Reference getReference2() {
        return reference2;
    }

    @Override
    public int getReferenceType2() {
        return opcode.referenceType2;
    }

    @Override
    public Format getFormat() {
        return FORMAT;
    }
}
