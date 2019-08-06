/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.common.sysflag;

public class PullSysFlag {
    /**
     * 2的0次方
     */
    private final static int FLAG_COMMIT_OFFSET = 0x1 << 0;
    /**
     * 2的1次方
     */
    private final static int FLAG_SUSPEND = 0x1 << 1;
    /**
     * 2的2次方
     */
    private final static int FLAG_SUBSCRIPTION = 0x1 << 2;
    /**
     * 2的三次方
     */
    private final static int FLAG_CLASS_FILTER = 0x1 << 3;

    /**
     * 计算系统标志
     *
     * @param commitOffset
     * @param suspend
     * @param subscription
     * @param classFilter
     * @return
     */
    public static int buildSysFlag(final boolean commitOffset, final boolean suspend,
                                   final boolean subscription, final boolean classFilter) {
        int flag = 0;

        if (commitOffset) {
            flag |= FLAG_COMMIT_OFFSET;
        }

        if (suspend) {
            flag |= FLAG_SUSPEND;
        }

        if (subscription) {
            flag |= FLAG_SUBSCRIPTION;
        }

        if (classFilter) {
            flag |= FLAG_CLASS_FILTER;
        }

        return flag;
    }

    public static int clearCommitOffsetFlag(final int sysFlag) {
        return sysFlag & (~FLAG_COMMIT_OFFSET);
    }

    /**
     * 已经提交
     *
     * @param sysFlag
     * @return
     */
    public static boolean hasCommitOffsetFlag(final int sysFlag) {
        return (sysFlag & FLAG_COMMIT_OFFSET) == FLAG_COMMIT_OFFSET;
    }

    /**
     * 已经挂起
     *
     * @param sysFlag
     * @return
     */
    public static boolean hasSuspendFlag(final int sysFlag) {
        return (sysFlag & FLAG_SUSPEND) == FLAG_SUSPEND;
    }

    /**
     * 判断是否存在订阅flag
     *
     * @param sysFlag
     * @return
     */
    public static boolean hasSubscriptionFlag(final int sysFlag) {
        return (sysFlag & FLAG_SUBSCRIPTION) == FLAG_SUBSCRIPTION;
    }

    /**
     * 判断是否有类过滤器
     *
     * @param sysFlag
     * @return
     */
    public static boolean hasClassFilterFlag(final int sysFlag) {
        return (sysFlag & FLAG_CLASS_FILTER) == FLAG_CLASS_FILTER;
    }
}
