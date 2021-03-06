/**
 * Copyright (C) 2007 Google Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */

package org.hibernate.shards.loadbalance;

import org.hibernate.shards.ShardId;

import java.util.List;
import java.util.Random;

/**
 * Random selection load balancing algorithm.
 *
 * @author maxr@google.com (Max Ross)
 */
public class RandomShardLoadBalancer extends BaseShardLoadBalancer {

    private final Random rand = new Random(System.currentTimeMillis());

    /**
     * Construct a RandomShardLoadBalancer
     *
     * @param shardIds the ShardIds that we're balancing across
     */
    public RandomShardLoadBalancer(final List<ShardId> shardIds) {
        super(shardIds);
    }

    @Override
    protected int getNextIndex() {
        // Implementation of nextInt() seems to indicate that this method is
        // threadsafe.  I sure hope I'm right about that.
        return rand.nextInt();
    }
}
