/*
 * Decompiled with CFR 0.151-SNAPSHOT (68aaa55).
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package com.br.samples.ktutorials;

import com.br.samples.ktutorials.InlineFunKt;
import com.br.samples.ktutorials.ToggleLockProcessHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 4, 1}, bv={1, 0, 3}, k=2, d1={"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001a;\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u001a5\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007\u00a2\u0006\u0002\u0010\b\u001a\u0006\u0010\r\u001a\u00020\u0001\u001a\u001a\u0010\u000e\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0086\b\u00f8\u0001\u0000\u001a\"\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0086\b\u00f8\u0001\u0000\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u001a\u001c\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u001a\"\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0086\b\u00f8\u0001\u0000\u001a;\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u001a\u0006\u0010\u0014\u001a\u00020\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0015"}, d2={"anotherInlinedProcess", "", "T", "lock", "Lcom/br/samples/ktutorials/ToggleLockProcessHelper;", "data", "processing", "Lkotlin/Function1;", "(Lcom/br/samples/ktutorials/ToggleLockProcessHelper;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "anotherNoInlinedLambda", "fn", "Lkotlin/Function0;", "anotherNonInlinedProcess", "callLambaExpressions", "inlined", "inlinedLockAndProcess", "main", "noInlinedLambda", "noInlinedLockAndProcess", "process", "sampleInlineAndNoInlineFunCalls", "AnotherCoroutinesSample"})
public final class InlineFunKt {
    @NotNull
    public static final Function0<Unit> noInlinedLambda(@NotNull Function0<Unit> fn) {
        Intrinsics.checkNotNullParameter(fn, (String)"fn");
        return fn;
    }

    public static final void anotherNoInlinedLambda(@NotNull Function0<Unit> fn) {
        Intrinsics.checkNotNullParameter(fn, (String)"fn");
        fn.invoke();
    }

    public static final void inlined(@NotNull Function0<Unit> fn) {
        int $i$f$inlined = 0;
        Intrinsics.checkNotNullParameter(fn, (String)"fn");
        fn.invoke();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void noInlinedLockAndProcess(@NotNull ToggleLockProcessHelper lock, @NotNull Function0<Unit> processing) {
        Intrinsics.checkNotNullParameter((Object)lock, (String)"lock");
        Intrinsics.checkNotNullParameter(processing, (String)"processing");
        boolean $i$f$process = false;
        lock.lock();
        try {
            processing.invoke();
        }
        finally {
            lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void inlinedLockAndProcess(@NotNull ToggleLockProcessHelper lock, @NotNull Function0<Unit> processing) {
        int $i$f$inlinedLockAndProcess = 0;
        Intrinsics.checkNotNullParameter((Object)lock, (String)"lock");
        Intrinsics.checkNotNullParameter(processing, (String)"processing");
        boolean $i$f$process = false;
        lock.lock();
        try {
            processing.invoke();
        }
        finally {
            InlineMarker.finallyStart((int)1);
            lock.unlock();
            InlineMarker.finallyEnd((int)1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void process(@NotNull ToggleLockProcessHelper lock, @NotNull Function0<Unit> processing) {
        int $i$f$process = 0;
        Intrinsics.checkNotNullParameter((Object)lock, (String)"lock");
        Intrinsics.checkNotNullParameter(processing, (String)"processing");
        lock.lock();
        try {
            processing.invoke();
        }
        finally {
            InlineMarker.finallyStart((int)1);
            lock.unlock();
            InlineMarker.finallyEnd((int)1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final <T> void anotherNonInlinedProcess(@NotNull ToggleLockProcessHelper lock, T data, @NotNull Function1<? super T, Unit> processing) {
        Intrinsics.checkNotNullParameter((Object)lock, (String)"lock");
        Intrinsics.checkNotNullParameter(processing, (String)"processing");
        boolean $i$f$process = false;
        lock.lock();
        try {
            processing.invoke(data);
        }
        finally {
            lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final <T> void anotherInlinedProcess(@NotNull ToggleLockProcessHelper lock, T data, @NotNull Function1<? super T, Unit> processing) {
        int $i$f$anotherInlinedProcess = 0;
        Intrinsics.checkNotNullParameter((Object)lock, (String)"lock");
        Intrinsics.checkNotNullParameter(processing, (String)"processing");
        boolean $i$f$process = false;
        lock.lock();
        try {
            processing.invoke(data);
        }
        finally {
            InlineMarker.finallyStart((int)1);
            lock.unlock();
            InlineMarker.finallyEnd((int)1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final <T> void process(@NotNull ToggleLockProcessHelper lock, T data, @NotNull Function1<? super T, Unit> processing) {
        int $i$f$process = 0;
        Intrinsics.checkNotNullParameter((Object)lock, (String)"lock");
        Intrinsics.checkNotNullParameter(processing, (String)"processing");
        lock.lock();
        try {
            processing.invoke(data);
        }
        finally {
            InlineMarker.finallyStart((int)1);
            lock.unlock();
            InlineMarker.finallyEnd((int)1);
        }
    }

    public static final void callLambaExpressions() {
        InlineFunKt.noInlinedLambda((Function0<Unit>)((Function0)callLambaExpressions.1.INSTANCE)).invoke();
        InlineFunKt.anotherNoInlinedLambda((Function0<Unit>)((Function0)callLambaExpressions.2.INSTANCE));
        boolean $i$f$inlined = false;
        boolean bl = false;
        String string = "inlined fun";
        boolean bl2 = false;
        System.out.println((Object)string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final void sampleInlineAndNoInlineFunCalls() {
        ToggleLockProcessHelper lock$iv = new ToggleLockProcessHelper();
        boolean $i$f$inlinedLockAndProcess = false;
        boolean $i$f$process = false;
        lock$iv.lock();
        try {
            boolean bl = false;
            String string = "Baixando configuracoes ...";
            boolean bl2 = false;
            System.out.println((Object)string);
        }
        finally {
            lock$iv.unlock();
        }
        InlineFunKt.noInlinedLockAndProcess(new ToggleLockProcessHelper(), (Function0<Unit>)((Function0)sampleInlineAndNoInlineFunCalls.2.INSTANCE));
        lock$iv = new ToggleLockProcessHelper();
        int data$iv = 0x200000;
        boolean $i$f$anotherInlinedProcess = false;
        boolean $i$f$process2 = false;
        lock$iv.lock();
        try {
            int it = data$iv;
            boolean bl = false;
            int n = it ^ 0xF;
            boolean bl3 = false;
            System.out.println(n);
        }
        finally {
            lock$iv.unlock();
        }
        InlineFunKt.anotherNonInlinedProcess(new ToggleLockProcessHelper(), 0x200000, sampleInlineAndNoInlineFunCalls.4.INSTANCE);
    }

    public static final void main() {
        InlineFunKt.sampleInlineAndNoInlineFunCalls();
    }

    public static /* synthetic */ void main(String[] stringArray) {
        InlineFunKt.main();
    }
}
