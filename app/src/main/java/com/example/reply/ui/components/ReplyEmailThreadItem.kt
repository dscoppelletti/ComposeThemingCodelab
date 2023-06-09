/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.reply.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.reply.R
import com.example.reply.data.Email

@Composable
fun ReplyEmailThreadItem(
    email: Email,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            /* BEGIN-4.4 - Adding colors to app */
            // By default, List item falls back to default tonal surface color.
            // You'll apply background color to the list item to create
            // separation and add padding to provide spacing around our
            // background.
            .background(
                MaterialTheme.colorScheme.background,
                /* BEGIN-7.2 - Working with shape */
                // Uniform list appearance between home screen and detail page.
                MaterialTheme.shapes.medium
                /* END-7.2 */
            )
            /* END-4.4 */
            .padding(20.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            ReplyProfileImage(
                drawableResource = email.sender.avatar,
                description = email.sender.fullName,
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = email.sender.firstName,
                    /* BEGIN-6.2 - Working with typography */
                    style = MaterialTheme.typography.labelMedium
                    /* END-6.2 */
                )
                Text(
                    text = stringResource(id = R.string.twenty_mins_ago),
                    /* BEGIN-6.2 - Working with typography */
                    style = MaterialTheme.typography.labelMedium
                    /* END-6.2 */
                )
            }
            IconButton(
                onClick = { /*Click Implementation*/ },
                modifier = Modifier
                    .clip(CircleShape)
            ) {
                Icon(
                    imageVector = if (email.isStarred) Icons.Default.Star else Icons.Default.StarBorder,
                    contentDescription = stringResource(id = R.string.description_favorite),
                    tint = if (email.isStarred) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.outline
                )
            }
        }

        Text(
            text = email.subject,
            /* BEGIN-6.2 - Working with typography */
            style = MaterialTheme.typography.bodyMedium,
            /* END-6.2 */
            modifier = Modifier.padding(top = 12.dp, bottom = 8.dp),
        )

        Text(
            text = email.body,
            /* BEGIN-6.2 - Working with typography */
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
            /* END-6.2 */
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Button(
                onClick = { /*Click Implementation*/ },
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = stringResource(id = R.string.reply),
                )
            }
            Button(
                onClick = { /*Click Implementation*/ },
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = stringResource(id = R.string.reply_all),
                )
            }
        }
    }
}
