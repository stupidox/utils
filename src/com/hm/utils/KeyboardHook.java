package com.hm.utils;

import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

/*
对应值	对应键
1	鼠标左键
2	鼠标右键
3	Cancel
4	鼠标中键
5	X1鼠标按钮
6	X2鼠标按钮
8	Backspace
9	Tab
12	Clear
13	Enter
16	Shift
17	Ctrl
18	ALt
19	Pause
20	Caps Lock
27	Esc
32	Space
33	Page Up
34	Page Down
35	End
36	Home
37	Left Arrow
38	Up Arrow
39	Right Arrow
40	Down Arrow
41	Select
42	Print
43	Execute
44	Snapshot
45	Insert
46	Delete
47	Help
48	0
49	1
50	2
51	3
52	4
53	5
54	6
55	7
56	8
57	9
65	A
66	B
67	C
68	D
69	E
70	F
71	G
72	H
73	I
74	J
75	K
76	L
77	M
78	N
79	O
80	P
81	Q
82	R
83	S
84	T
85	U
86	V
87	W
88	X
89	Y
90	Z
91	左Windows键（自然键盘）
92	右Windows键（自然键盘）
93	应用程序键（自然键盘）
95	电脑睡眠键
96	小键盘0
97	小键盘1
98	小键盘2
99	小键盘3
100	小键盘4
101	小键盘5
102	小键盘6
103	小键盘7
104	小键盘8
105	小键盘9
106	小键盘 *
107	小键盘 +
108	小键盘 Enter
109	小键盘 -
110	小键盘 .
111	小键盘 /
112	F1
113	F2
114	F3
115	F4
116	F5
117	F6
118	F7
119	F8
120	F9
121	F10
122	F11
123	F12
144	Num Lock
145	Scroll
160	左SHIFT键
161	右SHIFT键
162	左CONTROL键
163	右CONTROL键
164	左MENU键
165	右MENU键
166	浏览器后退键
167	浏览器前进键
168	浏览器刷新键
169	浏览器停止键
170	浏览器搜索键
171	浏览器收藏夹键
172	浏览器开始和主页键
173	音量静音键
174	降低音量键
175	调高音量键
176	下一曲目键
177	上一曲目键
178	停止媒体键
179	播放/暂停媒体键
180	启动邮件密钥
181	选择媒体密钥
182	启动应用程序1键
183	启动应用程序2键
186	;:
187	=+
189	#NAME?
191	/?
192	`~
219	[{
220	\ |
221	]}
222	'"
*/

public class KeyboardHook implements Runnable {
    private WinUser.HHOOK hhk;

    // 钩子回调函数
    private final WinUser.LowLevelKeyboardProc keyboardProc = new WinUser.LowLevelKeyboardProc() {
        @Override
        public WinDef.LRESULT callback(int nCode, WinDef.WPARAM wParam, WinUser.KBDLLHOOKSTRUCT event) {
            if (nCode >= 0) {
                switch (wParam.intValue()) {
                    case WinUser.WM_KEYDOWN:// 只监听键盘按下
                        // 按下小键盘7键退出
                        if (event.vkCode == 103) {
                            KeyboardHook.this.setHookOff();
                            Constants.showDialog("ext!");
                            System.exit(0);
                        }
                        // 按下的是shift键时，标记一下
                        // else if (event.vkCode == 160) {
                        //     Constants.isShiftUp = true;
                        // }
                        // 按下的是小键盘1键时，开启连点器
                        else if (event.vkCode == 97) {
                            new Thread(new AdvancedMouseClicker()).start();
                        }
                        // 按下的是小键盘2键时，开启秒杀连点器7
                        else if (event.vkCode == 98) {
                            new Thread(new SGSUtils()).start();
                        }
                        // 按下的是小键盘3键时，开启B站刷弹幕
                        else if (event.vkCode == 99) {
                            new Thread(new CommentsSender()).start();
                        }
                        // 按下的是小键盘9键时，取消连点器7
                        else if (event.vkCode == 105) {
                            new Thread(() -> {
                                while (Constants.f.getAndSet(false)) {
                                    System.out.println("正在取消连点器...");
                                }
                                System.out.println("取消连点器成功！");
                                Constants.showDialog("end!");
                                try {
                                    Thread.sleep(1000);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                Constants.f.getAndSet(true);
                            }).start();
                        }
                        break;
                    case WinUser.WM_KEYUP:// 按键起来
                        // if (event.vkCode == 160) {
                        //     Constants.isShiftUp = false;
                        // }
                        break;
                }
            }
            return User32.INSTANCE.CallNextHookEx(hhk, nCode, wParam, null);
        }
    };

    @Override
    public void run() {
        setHookOn();
    }

    // 安装钩子
    public void setHookOn() {
        WinDef.HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
        hhk = User32.INSTANCE.SetWindowsHookEx(User32.WH_KEYBOARD_LL, keyboardProc, hMod, 0);

        int result;
        WinUser.MSG msg = new WinUser.MSG();
        while ((result = User32.INSTANCE.GetMessage(msg, null, 0, 0)) != 0) {
            if (result == -1) {
                setHookOff();
                break;
            } else {
                User32.INSTANCE.TranslateMessage(msg);
                User32.INSTANCE.DispatchMessage(msg);
            }
        }
    }

    // 移除钩子并退出
    public void setHookOff() {
        User32.INSTANCE.UnhookWindowsHookEx(hhk);
    }
}
