/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.jstorm.container.cgroup;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.alibaba.jstorm.container.SubSystemType;
import com.alibaba.jstorm.container.cgroup.core.BlkioCore;
import com.alibaba.jstorm.container.cgroup.core.CgroupCore;
import com.alibaba.jstorm.container.cgroup.core.CpuCore;
import com.alibaba.jstorm.container.cgroup.core.CpuacctCore;
import com.alibaba.jstorm.container.cgroup.core.CpusetCore;
import com.alibaba.jstorm.container.cgroup.core.DevicesCore;
import com.alibaba.jstorm.container.cgroup.core.FreezerCore;
import com.alibaba.jstorm.container.cgroup.core.MemoryCore;
import com.alibaba.jstorm.container.cgroup.core.NetClsCore;
import com.alibaba.jstorm.container.cgroup.core.NetPrioCore;

public class CgroupCoreFactory {

    public static Map<SubSystemType, CgroupCore> getInstance(Set<SubSystemType> types, String dir) {
        Map<SubSystemType, CgroupCore> result = new HashMap<SubSystemType, CgroupCore>();
        for (SubSystemType type : types) {
            switch (type) {
            case blkio:
                result.put(SubSystemType.blkio, new BlkioCore(dir));
                break;
            case cpuacct:
                result.put(SubSystemType.cpuacct, new CpuacctCore(dir));
                break;
            case cpuset:
                result.put(SubSystemType.cpuset, new CpusetCore(dir));
                break;
            case cpu:
                result.put(SubSystemType.cpu, new CpuCore(dir));
                break;
            case devices:
                result.put(SubSystemType.devices, new DevicesCore(dir));
                break;
            case freezer:
                result.put(SubSystemType.freezer, new FreezerCore(dir));
                break;
            case memory:
                result.put(SubSystemType.memory, new MemoryCore(dir));
                break;
            case net_cls:
                result.put(SubSystemType.net_cls, new NetClsCore(dir));
                break;
            case net_prio:
                result.put(SubSystemType.net_prio, new NetPrioCore(dir));
                break;
            default:
                break;
            }
        }
        return result;
    }

}
