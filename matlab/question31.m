function [linelength,eta,beta,W0]=question31(beta_deg,d,ds)
eta=0.09;
W0 = 0;
% 模型参数
%ds=0;%该测线与离中心的测线的距离，由此可以依次确定相邻两测线间距
theta_deg = 120; % 换能器开角 （ 度）
alpha_deg = 1.5; % 坡度（度）
D0 =110/1852; % 海水深度（米）
% d = 0.1;%间距
%ds=ds+d; %该测线与离中心的测线的距离，由此可以依次确定相邻两测线间距
l=0; %相当于第二问中与海域中心点的距离,写这个只是为了说明这个变量的意义
sumlinelength=0;

d1=[];
beta1=[];
W01=[];
eta1=[] ;


% 将角度转换为弧度
theta = deg2rad(theta_deg) ; alpha = deg2rad(alpha_deg) ;
beta = deg2rad(beta_deg) ; gamma=atan(sin(beta)*tan(alpha));
alpha=gamma;

%测线距中心点处的距离



distance_x=[];
% 给定矩形的参数
a = 1.9993;  % 矩形的高度（上下两条边的y值之差的一半）
b = 1;  % 矩形的宽度（左右两条边的x值之差的一半）

% 直线参数
k = tan(beta-pi/2);  % 直线斜率
b_line = ds/sin(beta);  % 直线的截距
linelength=0;

% 计算直线与四条边的交点
intersections = [];

% 计算直线与y=a的交点
x_inter = (a - b_line) / k;
if -b <= x_inter && x_inter <= b
    intersections = [intersections; x_inter, a];
end

% 计算直线与y=-a的交点
x_inter = (-a - b_line) / k;
if -b <= x_inter && x_inter <= b
    intersections = [intersections; x_inter, -a];
end

% 计算直线与x=b的交点
y_inter = k * b + b_line;
if -a <= y_inter && y_inter <= a
    intersections = [intersections; b, y_inter];
end

% 计算直线与x=-b的交点
y_inter = k * -b + b_line;
if -a <= y_inter && y_inter <= a
    intersections = [intersections; -b, y_inter];
end

% 显示满足条件的交点坐标和距离
%disp('满足条件的交点坐标和距离:');
for i = 1:size(intersections, 1)
    for j = i+1:size(intersections, 1)
        x1 = intersections(i, 1);
        y1 = intersections(i, 2);
        x2 = intersections(j, 1);
        y2 = intersections(j, 2);

        % 计算两个交点之间的距离
        linelength = sqrt((x2 - x1)^2 + (y2 - y1)^2);

        % 显示交点坐标和距离
        %     fprintf('交点 %d 和交点 %d 之间的距离为 %.2f\n', i, j, linelength);
    end
    % 输出位于 x = b 或 y = a 处的交点坐标
    for i = 1:size(intersections, 1)
        if abs(intersections(i,1) - b) < 1e-6 || abs(intersections(i,2) - a) < 1e-6
            %      disp('位于 x = b 或 y = a 处的交点坐标：');
            %      disp(intersections(i, :));
        end
    end
    x = intersections(i, 1);
    y = intersections(i, 2);

    % 计算交点到 x 轴的距离
    distance_x_axis = abs(y)/sin(beta);
    distance_x=[distance_x,distance_x_axis];

end


sumlinelength=sumlinelength+linelength;
if ~isempty(distance_x)
    for i=1:2
        l=distance_x(i)-d;

        % D为换能器处的海水深度
        D1=D0-l*tan(alpha);
        % 计算波束的覆盖宽度
        x0L=D1*(sin(theta/2)/sin(pi/2-alpha-theta/2));
        x0R=D1*(sin(theta/2)/sin(pi/2+alpha-theta/2));
        W0 = x0L+x0R;

        %测线距中心点处的距离
        l=l+d;
        % D为换能器处的海水深度
        D2=D0-l*tan(alpha);
        % 计算波束的覆盖宽度
        x1L=D2*(sin(theta/2)/sin(pi/2-alpha-theta/2));
        x1R=D2*(sin(theta/2)/sin(pi/2+alpha-theta/2));
        W1 = x1L+x1R ;

        % 计算相邻条带之间的重叠率
        eta = (x0R+x1L-d/cos(alpha))/W1;
        %
        %         eta1=[eta1,eta] ;
        %         beta1=[beta1,beta_deg];
        %         d1=[d1,0.3];
        %         W01=[W01,W0];
        %
    end
end
% end


% 创建包含自变量和因变量的矩阵
data = [beta1',W01',eta1'];

% 将数据写入 Excel 表格
% filename = 'data2.xlsx';
% sheet = 1;
% xlswrite(filename, data, sheet);
