package com.example.gogoma.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gogoma.R
import com.example.gogoma.theme.BrandColor1
import com.example.gogoma.theme.GogomaTheme
import com.example.gogoma.theme.NeutralDark
import com.example.gogoma.theme.NeutralLight

@Composable
fun AgreementItem(
    isRequired: Boolean = false,
    text: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onViewClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 0.4.dp, color = NeutralLight, shape = RoundedCornerShape(size = 16.dp))
            .background(color = MaterialTheme.colorScheme.background, shape = RoundedCornerShape(size = 16.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onCheckedChange(!isChecked) } // 클릭 시 상태 변경
                .padding(horizontal = 20.dp, vertical = 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 체크박스 아이콘
            IconButton(
                onClick = { onCheckedChange(!isChecked) },
                modifier = Modifier.size(24.dp).padding(0.dp)
            ) {
                Icon(
                    painter = painterResource(
                        id = if (isChecked) R.drawable.icon_check_circle_fill else R.drawable.icon_check_circle
                    ),
                    contentDescription = "Checkbox",
                    tint = if (isChecked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.size(4.dp))

            if(isRequired) {
                Text(
                    text = "(필수)",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.size(4.dp))
            }
            // 텍스트
            Text(
                text = text,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.weight(1f) // 남은 공간을 차지해서 정렬
            )

            IconButton(
                onClick = { onViewClicked() },
                modifier = Modifier.size(20.dp).padding(0.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_arrow_forward_ios),
                    contentDescription = "Back Arrow",
                    tint = Color(0xFFCFCFCF),
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AgreementItemPreview() {
    var checked by remember { mutableStateOf(true) }

    GogomaTheme {
        AgreementItem(
            text = "선택하면 이렇게 표시됨 + 약관 두번째 스타일",
            isChecked = checked,
            onCheckedChange = { checked = it },
            onViewClicked = { /* 클릭 이벤트 */ }
        )
    }
}
