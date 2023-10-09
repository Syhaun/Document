clear; clc;
ds = 0; % 该测线与离中心的测线的距离，由此可以依次确定相邻两测线间距
ls = 0;
op = 0;
ds_a = 0;
beta_deg = 90;
target_eta1 = 0.1; % 目标 eta1 值
best_d = 0; % 最接近目标 eta1 的 d 值
best_eta_diff = inf; % 目标 eta1 与当前最佳 d 对应的 eta1 差异
for i = 0:100
    beta_deg = beta_deg + i;
    while ds_a < 5
        ds_a = best_d + ds_a;
        for j = 1:100
            d = 0.01 * j;
            if op == 0
                ds = d;
                [linelength, eta, ~, ~] = question31(beta_deg, d, ds);
            end
            if op > 0
                [linelength, eta, ~, ~] = question31(beta_deg, d, ds_a);
            end
            if eta>=0.1
                eta_diff = eta - target_eta1; % 计算当前 eta1 与目标 eta1 的差异
            
            else
                continue;
            end
            if eta_diff < best_eta_diff
                best_eta_diff = eta_diff;
                best_d = d;
            end
        end
        op = op + 1;
        disp(best_d);
        disp(ds_a)
    end
end
