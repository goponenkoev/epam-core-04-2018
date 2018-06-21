package com.epam.homework.task25;

import java.util.Stack;

public class Task25Impl implements Task25 {

    /**
     * Проверяет правильность расстановки скобок.
     * Правильная расстановка:
     * 1) Каждой открывающей скобке соответствует закрывающая того же типа.
     * 2) Нет пересечения областей, обрамленных скобками.
     *
     * @param string Анализируемая строка.
     * @return true - скобки расставлены верно, иначе - false.
     */
    @Override
    public boolean isNormalBrackets(String string) {
        Stack<Byte> stackBrackets = new Stack<>();
        // () - 0
        // {} - 1
        // [] - 2

        for (int j = 0; j < string.length(); j++) {
            switch (string.charAt(j)) {
                case '(':
                    stackBrackets.push((byte)0);
                    break;
                case ')':
                    if ((stackBrackets.empty()) || (!stackBrackets.pop().equals((byte)0))) return false;
                    break;
                case '{':
                    stackBrackets.push((byte)1);
                    break;
                case '}':
                    if ((stackBrackets.empty()) || (!stackBrackets.pop().equals((byte)1))) return false;
                    break;
                case '[':
                    stackBrackets.push((byte)2);
                    break;
                case ']':
                    if ((stackBrackets.empty()) || (!stackBrackets.pop().equals((byte)2))) return false;
                    break;
                default:
                    break;
            }
        }
        return stackBrackets.empty();
    }
}
